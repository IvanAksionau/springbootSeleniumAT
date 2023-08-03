package com.ea.springbasic.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class DriverScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        SessionId sessionId = ((ChromeDriver) o).getSessionId();
        if (sessionId == null) {
            super.remove(name);
            o = super.get(name, objectFactory);
            System.out.println("Session ID is null, new session is OPENED " + ((RemoteWebDriver) o).getSessionId());
        }
        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // do nothing
    }
}
