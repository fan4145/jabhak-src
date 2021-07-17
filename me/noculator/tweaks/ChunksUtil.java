/*    */ package me.noculator.tweaks;
/*    */ 
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ public class ChunksUtil
/*    */   extends Chunks {
/*    */   String username;
/*    */   String content;
/*    */   @SerializedName("avatar_url")
/*    */   String avatarUrl;
/*    */   @SerializedName("tts")
/*    */   boolean textToSpeech;
/*    */   
/*    */   public ChunksUtil() {
/* 15 */     this(null, "", null, false);
/*    */   }
/*    */   
/*    */   public ChunksUtil(String content) {
/* 19 */     this(null, content, null, false);
/*    */   }
/*    */   
/*    */   public ChunksUtil(String username, String content, String avatar_url) {
/* 23 */     this(username, content, avatar_url, false);
/*    */   }
/*    */   public ChunksUtil(String username, String content, String avatar_url, boolean tts) {
/* 26 */     capeUsername(username);
/* 27 */     setCape(content);
/* 28 */     checkCapeUrl(avatar_url);
/* 29 */     isDev(tts);
/*    */   }
/*    */   
/*    */   public void capeUsername(String username) {
/* 33 */     if (username != null) {
/* 34 */       this.username = username.substring(0, Math.min(31, username.length()));
/*    */     } else {
/* 36 */       this.username = null;
/*    */     } 
/*    */   }
/*    */   public void setCape(String content) {
/* 40 */     this.content = content;
/*    */   }
/*    */   public void checkCapeUrl(String avatarUrl) {
/* 43 */     this.avatarUrl = avatarUrl;
/*    */   }
/*    */   public void isDev(boolean textToSpeech) {
/* 46 */     this.textToSpeech = textToSpeech;
/*    */   }
/*    */   
/*    */   public static class Builder {
/*    */     private final ChunksUtil message;
/*    */     
/*    */     public Builder() {
/* 53 */       this.message = new ChunksUtil();
/*    */     }
/*    */     public Builder(String content) {
/* 56 */       this.message = new ChunksUtil(content);
/*    */     }
/*    */     
/*    */     public Builder withUsername(String username) {
/* 60 */       this.message.capeUsername(username);
/* 61 */       return this;
/*    */     }
/*    */     
/*    */     public Builder withContent(String content) {
/* 65 */       this.message.setCape(content);
/* 66 */       return this;
/*    */     }
/*    */     
/*    */     public Builder withAvatarURL(String avatarURL) {
/* 70 */       this.message.checkCapeUrl(avatarURL);
/* 71 */       return this;
/*    */     }
/*    */     
/*    */     public Builder withDev(boolean tts) {
/* 75 */       this.message.isDev(tts);
/* 76 */       return this;
/*    */     }
/*    */     
/*    */     public ChunksUtil build() {
/* 80 */       return this.message;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\SusanLindsay\Downloads\JabHak.safe.jar!\me\noculator\tweaks\ChunksUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */