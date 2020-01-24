package com.bagel.rosewood.common.entity;

import com.bagel.rosewood.core.Rosewood;
import com.bagel.rosewood.core.registry.RosewoodBlocks;
import com.bagel.rosewood.core.registry.RosewoodItems;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Rosewood.MODID)
public class VillagerTrades {
	
	@SubscribeEvent
	public static void onWandererTradesEvent(WandererTradesEvent event) {
		event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(RosewoodBlocks.MONKEY_BRUSH.get(), 1, 1, 6, 1));
		event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(RosewoodBlocks.ROSEWOOD_SAPLING.get(), 5, 1, 8, 1));
		event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(RosewoodBlocks.PASSION_VINE.get(), 3, 1, 8, 1));
	}
	
	@SubscribeEvent
	public static void onVillagerTradesEvent(VillagerTradesEvent event) {
		if(event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(5).add(new TradeUtils.ItemsForEmeraldsTrade(RosewoodItems.SHIMMERING_PASSIONFRUIT.get(), 3, 3, 5, 30));	
		}
    }
}
