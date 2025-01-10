package wily.legacy.client;

import wily.legacy.config.LegacyConfig;
import wily.legacy.config.LegacyConfigDisplay;
import wily.legacy.util.LegacyComponents;

public class LegacyMixinOptions {
    public static final LegacyConfig.StorageHandler CLIENT_MIXIN_STORAGE = new LegacyConfig.StorageHandler("legacy/client_mixin.json");

    public static final LegacyConfig<Boolean> legacyInventoryScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.inventory", ()-> new LegacyConfigDisplay<>("legacyInventoryScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyClassicCraftingScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.crafting", ()-> new LegacyConfigDisplay<>("legacyClassicCraftingScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyClassicStonecutterScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.stonecutter", ()-> new LegacyConfigDisplay<>("legacyClassicStonecutterScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyClassicLoomScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.loom", ()-> new LegacyConfigDisplay<>("legacyClassicLoomScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyClassicMerchantScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.merchant", ()-> new LegacyConfigDisplay<>("legacyClassicMerchantScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyCrafterScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.crafter", ()-> new LegacyConfigDisplay<>("legacyCrafterScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyFurnaceScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.furnace", ()-> new LegacyConfigDisplay<>("legacyFurnaceScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyAnvilScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.anvil", ()-> new LegacyConfigDisplay<>("legacyAnvilScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacySmithingScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.smithing", ()-> new LegacyConfigDisplay<>("legacySmithingScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyGrindstoneScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.grindstone", ()-> new LegacyConfigDisplay<>("legacyGrindstoneScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyCartographyScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.cartography", ()-> new LegacyConfigDisplay<>("legacyCartographyScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyEnchantmentScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.enchantment", ()-> new LegacyConfigDisplay<>("legacyEnchantmentScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyBeaconScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.beacon", ()-> new LegacyConfigDisplay<>("legacyBeaconScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyBrewingStandScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.brewing", ()-> new LegacyConfigDisplay<>("legacyBrewingStandScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyBookScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.book", ()-> new LegacyConfigDisplay<>("legacyBookScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyCreateWorldScreen = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.create_world", ()-> new LegacyConfigDisplay<>("legacyCreateWorldScreen", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyGui = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.gui", ()-> new LegacyConfigDisplay<>("legacyGui", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyChat = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.chat", ()-> new LegacyConfigDisplay<>("legacyChat", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyBossHealth = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.bosshealth", ()-> new LegacyConfigDisplay<>("legacyBossHealth", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));
    public static final LegacyConfig<Boolean> legacyWitches = CLIENT_MIXIN_STORAGE.register(LegacyConfig.createBoolean("legacy.mixin.base.client.witch", ()-> new LegacyConfigDisplay<>("legacyWitches", b-> LegacyComponents.NEEDS_RESTART), true, b->{}, CLIENT_MIXIN_STORAGE));

}
