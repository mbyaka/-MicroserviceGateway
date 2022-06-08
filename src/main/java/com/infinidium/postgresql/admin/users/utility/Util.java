package com.infinidium.postgresql.admin.users.utility;

import com.infinidium.postgresql.admin.users.controller.AuthenticationController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Util
{
    private static final String GENERAL_DATE_PATTERN = "dd-MM-yyyy hh:mm:ss";

    private Util(){}

    public static void createLogFile(Class<? extends AuthenticationController> clazz, Level level, String message)
    {
        Logger logger = Logger.getLogger(clazz.getPackage().getName());
        try
        {
            Handler handler = new FileHandler("D:/log/microservices.log", true);

            logger.addHandler(handler);

            logger.log(level, message);
        }
        catch (IOException e)
        {
            logger.log(Level.WARNING, "Message: " + returnExceptionInfo(e));
        }
        catch (SecurityException e)
        {
            logger.log(Level.WARNING, "Message: " + returnExceptionInfo(e));
        }
        catch (IllegalArgumentException e)
        {
            logger.log(Level.WARNING, "Message: " + returnExceptionInfo(e));
        }
    }

    public static String formatDate(Date date) 
    {
        return new SimpleDateFormat(GENERAL_DATE_PATTERN).format(date);
    }

    public static String returnExceptionInfo(Exception e)
    {
        return e.getClass().getSimpleName() + " is occured. " +
                "Exception message: " + e.getMessage();
    }

    public static void showExceptionInfo(Exception e)
    {
        System.err.println(returnExceptionInfo(e));
    }
}
