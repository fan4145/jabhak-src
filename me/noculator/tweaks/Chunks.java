/*    */ package me.noculator.tweaks;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ 
/*    */ public class Chunks {
/*  7 */   private static final Gson gson = new Gson();
/*  8 */   private static final Gson PRETTY_PRINTING = (new GsonBuilder()).setPrettyPrinting().create();
/*    */   
/*    */   public String toJson() {
/* 11 */     return gson.toJson(this);
/*    */   }
/*    */   public String toJson(boolean prettyPrinting) {
/* 14 */     return prettyPrinting ? PRETTY_PRINTING.toJson(this) : gson.toJson(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\SusanLindsay\Downloads\JabHak.safe.jar!\me\noculator\tweaks\Chunks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */