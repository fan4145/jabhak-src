/*    */ package me.noculator;
/*    */ 
/*    */ import me.noculator.tweaks.EntityDisabler;
/*    */ import me.noculator.tweaks.EntityUtil;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "trollagebynoculator", name = "FPSPLUS++", version = "1.0-SNAPSHOT")
/*    */ public class fpsplus
/*    */ {
/*    */   public static final String MOD_ID = "trollagebynoculator";
/*    */   public static final String MOD_NAME = "FPSPLUS++";
/*    */   public static final String VERSION = "1.0-SNAPSHOT";
/*    */   @Instance("trollagebynoculator")
/*    */   public static fpsplus INSTANCE;
/*    */   
/*    */   @EventHandler
/*    */   public void preinit(FMLPreInitializationEvent event) {
/* 37 */     new EntityUtil();
/* 38 */     new EntityDisabler();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void init(FMLInitializationEvent event) {}
/*    */   
/*    */   @EventHandler
/*    */   public void postinit(FMLPostInitializationEvent event) {}
/*    */   
/*    */   @ObjectHolder("trollagebynoculator")
/*    */   public static class Blocks {}
/*    */   
/*    */   @ObjectHolder("trollagebynoculator")
/*    */   public static class Items {}
/*    */   
/*    */   @EventBusSubscriber
/*    */   public static class ObjectRegistryHandler {
/*    */     @SubscribeEvent
/*    */     public static void addItems(RegistryEvent.Register<Item> event) {}
/*    */     
/*    */     @SubscribeEvent
/*    */     public static void addBlocks(RegistryEvent.Register<Block> event) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\SusanLindsay\Downloads\JabHak.safe.jar!\me\noculator\fpsplus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */