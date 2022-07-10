package br.com.cep.consumindocepwebservice;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by andersondebrito on 7/26/2017.
 */
@Provider
public class GensonProvider implements ContextResolver<Genson> {

    private Genson genson = new GensonBuilder().setSkipNull(true).create();

    public Genson getContext(Class<?> aClass) {
        return genson;
    }
}
