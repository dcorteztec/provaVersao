package br.com.prova.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.prova.dao.impl.ItemDAO;
import br.com.prova.vo.ItemVO;

@FacesConverter("itemConverter")
public class ItemConverter  implements Converter {
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
    	if (newValue != null && !newValue.equals("")) {
    		InitialContext ctx;
    		ItemDAO dao = null;
			try {
				ctx = new InitialContext();
				dao = (ItemDAO) ctx.lookup("java:module/ItemDAO");
			} catch (NamingException e) {
				e.printStackTrace();
			}
            ItemVO tabDao = new ItemVO();
            tabDao = dao.find(Long.parseLong(newValue));
            return tabDao;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof ItemVO) {
        	ItemVO item = (ItemVO) object;
            Long name = item.getCodigo();
            return name.toString();
        } else {
            throw new ConverterException(new FacesMessage(object + " is not a valid item"));
        }
    }
}