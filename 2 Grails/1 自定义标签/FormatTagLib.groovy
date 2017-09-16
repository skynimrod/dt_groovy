import java.text.SimpleDateFormat  
  
class FormatTagLib {  
   static namespace = "topca"  
   def dateFormat={attr,body->  
       if(attr.dateString){  
            if(attr.dateString==~/^\d{14}$/){  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
                try{  
                    out<<sdf.parse(attr.dateString).format("yyyyÄêMMÔÂddÈÕ HH:mm:ss");  
                }catch(Exception e){  
                    out<<attr.dateString;  
                }  
            }else{  
                out<<attr.dateString;  
            }  
       }  
   }  
}  