package org.production.business.util.dto;

/**
 *
 * @author  Rachel Makwara
 */
public class ItemDeleteDTO extends NameIdDTO {
    
    private String cancelRedirect;
    
    public ItemDeleteDTO(){
        
    }

    public ItemDeleteDTO(String id, String name,String cancelRedirect) {
        super(name, id);
        this.cancelRedirect = cancelRedirect;
    }

    public String getCancelRedirect() {
        return cancelRedirect;
    }

    public void setCancelRedirect(String cancelRedirect) {
        this.cancelRedirect = cancelRedirect;
    }
    
}