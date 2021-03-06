package br.com.cwi.selenium.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Lucas Grando 27/08/2020
 *
 */
public class PropertiesUtil {
	
	private static Properties properties;

    /**
     * Seta as propriedades.
     */
    public static String get( String key ) {

        if ( properties == null ) {
        	
            loadProperties();
        }

        return properties.get( key ).toString();
    }

    /**
     * Carrega as propriedades do arquivo de configuração profile.properties.
     */
    private static void loadProperties() {

        properties = new Properties();

        try {

            properties.load( PropertiesUtil.class
                            .getResourceAsStream( "/configuration/profile.properties" ) );

        } catch ( IOException e ) {

            throw new IllegalArgumentException( "Não foi possivel carregar o arquivo de propriedades", e );
        }

    }
}
