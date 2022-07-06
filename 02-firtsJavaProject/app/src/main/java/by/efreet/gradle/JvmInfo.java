package by.efreet.gradle;

public class JvmInfo {
    private final String javaVersion;

    public JvmInfo(String v) {
        this.javaVersion = v;
    }

    public static JvmInfo current() {
        return new JvmInfo(System.getProperty("java.version"));
    }

    public String getVersion() {
        return javaVersion;
    }

    public String getMajor() {
        int dotIndex = javaVersion.indexOf(".");
        return dotIndex < 0 ? javaVersion: javaVersion.substring(0, dotIndex);
    }
}
