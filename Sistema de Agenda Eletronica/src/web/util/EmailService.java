package web.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailService {
	
	private final static String userAuthentication = "eletronica.agenda@gmail.com";  
    private final static String passwordUserAuthentication = "danty123";  
    private final static String sender = "AGENDA_ELETRONICA@GATOAJATO.COM.BR";  
    private final static String smtp = "smtp.gmail.com";  
    private final static boolean authentication = true;  
    
    public static void sendMailFaleConosco(String message, String receiver)  
            throws EmailException {  
  
    	HtmlEmail email = new HtmlEmail();  
        email.setHostName(smtp);  
        email.setAuthentication(userAuthentication, passwordUserAuthentication);  
        email.setSSL(authentication);  
        email.addTo(receiver);  
        email.setFrom(sender);  
        email.setSubject("FALE CONOSCO");  
        email.setHtmlMsg(message); 
        email.send();  
        email = null;  
        

    }  
    
    public static void sendMailCadastro(String message,String receiver)  
            throws EmailException {  
  
    	HtmlEmail email = new HtmlEmail();  
        email.setHostName(smtp);  
        email.setAuthentication(userAuthentication, passwordUserAuthentication);  
        email.setSSL(authentication);  
        email.addTo(receiver);  
        email.setFrom(sender);  
        email.setSubject("BOAS VINDAS - GATO A JATO - WEB AGENDA");  
        email.setHtmlMsg(message); 
        email.send();  
        email = null;  
        

    }  
    
    public static String emailCadastro(String nomeUsuario){
    	String msg;
    	
    	msg = "<html>"               
 	            + "<body  bgcolor='#EBEBEB'>"                    
 	            + "<h3>Fale Conosco </h3>"  
 	            + "<p>Prezado(a),</p>"    	              
    	            + "<strong>Nome:</strong> " + nomeUsuario + "<br/>"                
 	            + "Obrigado por realizar no seu cadastro no sistema Gato a Jato Web Agenda.<br/> " 
 	            + "Conosco seus compromissos estarão sempre bem guardados e atualizados.<br/> "  
 	            + "<br/>"  
 	            + "<br/>"  
 	            + "<div colspan='1' height='30' align='center'>"  
 	                + "<b><center>**** FAVOR NÃO RETORNAR ESTE EMAIL ****</center></b>"   
 	            + "</div>"
 	            + "<br/>"  
	            + "<br/>"  
 	            + "<div>"
	            + " <h7> Aviso de Confidencialidade: " +
	               "O conteúdo desta mensagem é de propriedade da GATO A JATO" +
	               " e pode conter informações confidenciais e/ou privilegiadas, " +
	               "sendo o seu teor dirigido apenas para o conhecimento da(s) pessoa(s) " +
	               "ou entidade(s) a quem se destina(m). A retransmissão, disseminação ou ainda " +
	               "qualquer outra utilização indevida do conteúdo desta mensagem é crime nos termos " +
	               "da legislação vigente. No caso de recebimento desta mensagem por erro ou engano, " +
	               "por favor, comunique o fato ao emissor e a exclua dos seus arquivos. </h7>"
	            + " </div>"
 	          
 	    + "</body>"  
 	    + "</html>";  
 	      
 	    return msg;  
    }
    
    public static String emailFaleConosco(String nome, String email, String assunto, String mensagem){
    	 String msg;  
         
    	    msg = "<html>"               
    	            + "<body  bgcolor='#EBEBEB'>"                    
    	            + "<h3>Fale Conosco </h3>"  
    	            + "<p>Prezado(a),</p>"    	              
       	            + "<strong>Nome:</strong> " + nome + "<br/>"  
    	            + "<strong>E-mail:</strong> " + email + "<br/>"  
    	            + "<strong>Assutno:</strong> " + assunto + "<br/>"                
    	            + "<strong>Mensagem:</strong><br/> " + mensagem                 
    	            + "<br/>"  
    	            + "<br/>"  
    	            + "<div colspan='1' height='30' align='center'>"  
    	                + "<b><center>**** FAVOR NÃO RETORNAR ESTE EMAIL ****</center></b>"   
    	            + "</div>"
    	            + "<br/>"  
    	            + "<br/>"  
     	            + "<div>"
    	            + " <h7> Aviso de Confidencialidade: " +
    	               "O conteúdo desta mensagem é de propriedade da GATO A JATO" +
    	               " e pode conter informações confidenciais e/ou privilegiadas, " +
    	               "sendo o seu teor dirigido apenas para o conhecimento da(s) pessoa(s) " +
    	               "ou entidade(s) a quem se destina(m). A retransmissão, disseminação ou ainda " +
    	               "qualquer outra utilização indevida do conteúdo desta mensagem é crime nos termos " +
    	               "da legislação vigente. No caso de recebimento desta mensagem por erro ou engano, " +
    	               "por favor, comunique o fato ao emissor e a exclua dos seus arquivos. </h7>"
    	            + " </div>"
    	          
    	    + "</body>"  
    	    + "</html>";  
    	      
    	    return msg;  
    }

}
