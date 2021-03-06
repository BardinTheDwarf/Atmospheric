package com.bagel.atmospheric.common.world.biome.dunes;

import com.bagel.atmospheric.common.world.biome.AtmosphericBiomeFeatures;
import com.bagel.atmospheric.core.registry.AtmosphericBiomes;
import com.bagel.atmospheric.core.registry.AtmosphericBlocks;
import com.bagel.atmospheric.core.registry.AtmosphericFeatures;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class DunesBiome extends Biome {
	public DunesBiome() {
		super((new Biome.Builder()
			.surfaceBuilder(AtmosphericFeatures.WAVEY_DUNES, new SurfaceBuilderConfig(
				AtmosphericBlocks.ARID_SAND.get().getDefaultState(), 
				AtmosphericBlocks.ARID_SAND.get().getDefaultState(), 
				Blocks.GRAVEL.getDefaultState()))
			.precipitation(Biome.RainType.NONE)
			.category(Biome.Category.DESERT)
			.depth(0.45F)
			.scale(0.15F)
			.temperature(2.0F)
			.downfall(0.0F)
			.waterColor(4159204)
			.waterFogColor(329011)
			.parent(null)));
		
		this.addStructure(AtmosphericFeatures.ARID_SHRINE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, AtmosphericFeatures.ARID_SHRINE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
	    this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addMonsterRooms(this);

		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		AtmosphericBiomeFeatures.addFossils(this);
		DefaultBiomeFeatures.addMushrooms(this);

		AtmosphericBiomeFeatures.addDeadBushes(this, 2);
		AtmosphericBiomeFeatures.addYuccaTrees(this, 0, 0.25F, 1, false);
		AtmosphericBiomeFeatures.addBarrelCactus(this, 0, 0.075F, 2);
		AtmosphericBiomeFeatures.addAloeVera(this, 2);
		AtmosphericBiomeFeatures.addYuccaFlower(this, 2);
		AtmosphericBiomeFeatures.addDuneRocks(this, 1, 2);
		
		DefaultBiomeFeatures.addFreezeTopLayer(this);

		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.HUSK, 80, 4, 4));
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public int getSkyColor() {
		return 14988944;
	}
	
	@Override
	public Biome getHill(net.minecraft.world.gen.INoiseRandom rand) {
		return rand.random(5) > 1 ? AtmosphericBiomes.DUNES_HILLS.get() : AtmosphericBiomes.FLOURISHING_DUNES.get();
	}
}
