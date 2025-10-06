package net.greeengoblin.simplehoverboards.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.greeengoblin.simplehoverboards.init.SimpleHoverboardsModEntities;

public class GreenHoverboardItemRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = SimpleHoverboardsModEntities.GREEN_HOVERBOARD.get().spawn(_level, BlockPos.containing(x, y + 1.2, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
	}
}