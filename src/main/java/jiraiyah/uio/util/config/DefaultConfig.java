package jiraiyah.uio.util.config;

public interface DefaultConfig
{
    String get( String namespace );

    static String empty( String namespace )
    {
        return "";
    }
}