package br.com.prova.utils;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class ManualCDILookup {
    @SuppressWarnings("unchecked")
	public <T> T getFacadeWithJNDI(Class<T> classToFind) throws NamingException {
        BeanManager bm = getBeanManager();
        Bean<T> bean = (Bean<T>) bm.getBeans(classToFind).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T dao = (T) bm.getReference(bean, classToFind, ctx);
        return dao;
    }
    private BeanManager getBeanManager() throws NamingException {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:module/ItemDAO");
        }
        catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
