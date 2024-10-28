package jiraiyah.uio.util.config;

public interface IConfigProvider
{
    String get( String namespace );

    static String empty( String namespace )
    {
        return "";
    }
}