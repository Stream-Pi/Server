/*
ServerInfo.java

Stores basic information about the server - name, platform type

Contributors: Debayan Sutradhar (@dubbadhar)
 */

package com.stream_pi.server.info;

import com.stream_pi.util.platform.Platform;
import com.stream_pi.util.platform.ReleaseStatus;
import com.stream_pi.util.version.Version;

public class ServerInfo {
    private Version version;
    private final ReleaseStatus releaseStatus;
    private final Platform platformType;

    private String prePath;

    private Version minThemeSupportVersion;
    private Version minPluginSupportVersion;
    private Version commStandardVersion;

    private static ServerInfo instance = null;
    
    private String runnerFileName = null;
    private boolean startMinimised = false; 

    private ServerInfo()
    {
        version = new Version(1,0,0);
        minThemeSupportVersion = new Version(1,0,0);
        minPluginSupportVersion = new Version(1,0,0);
        commStandardVersion = new Version(1,0,0);

        releaseStatus = ReleaseStatus.EA;
        prePath = System.getProperty("user.home")+"/Stream-Pi/Server/";

        String osName = System.getProperty("os.name").toLowerCase();

        if(osName.contains("windows"))
            platformType = Platform.WINDOWS;
        else if (osName.contains("linux"))
            platformType = Platform.LINUX;
        else if (osName.contains("mac"))
            platformType = Platform.MAC;
        else
            platformType = Platform.UNKNOWN;

    }

    
    public String getPrePath() {
        return prePath;
    }

    public void setStartMinimised(boolean startMinimised)
    {
        this.startMinimised = startMinimised;
    }

    public boolean isStartMinimised() 
    {
        return startMinimised;
    }

    public void setRunnerFileName(String runnerFileName)
    {
        this.runnerFileName = runnerFileName;
    }

    public String getRunnerFileName() 
    {
        return runnerFileName;
    }

    public static synchronized ServerInfo getInstance()
    {
        if(instance == null)
        {
            instance = new ServerInfo();
        }

        return instance;
    }


    public Platform getPlatformType()
    {
        return platformType;
    }

    public Version getVersion() {
        return version;
    }

    public ReleaseStatus getReleaseStatus()
    {
        return releaseStatus;
    }

    public Version getMinThemeSupportVersion()
    {
        return minThemeSupportVersion;
    }

    public Version getMinPluginSupportVersion()
    {
        return minPluginSupportVersion;
    }

    public Version getCommStandardVersion()
    {
        return commStandardVersion;
    }
}
