package me.sculk_sensor.doomsday.utils;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.entity.BulletEntity;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.atomic.AtomicInteger;

public final class ParticleUtil {
	public static void generateAttackTrajectories(Location location,
										   double deflection,
										   double startAngle, double rotAngle,
										   double radius,
										   double yDirExtend, double xDirExtend,
										   double extendPartInterval, double verticalInterval,
										   double rotSpeed, double rotDelay) {
		World world = location.getWorld();
		if (world == null) {
			return;
		}
		if (yDirExtend < 0) {
			yDirExtend = 0;
		}
		if (xDirExtend < 0) {
			xDirExtend = 0;
		}
		if (radius < xDirExtend) {
			radius = xDirExtend;
		}

	}
}
/*
if (yDirExtend < 0) {
			yDirExtend = 0;
		}
		if (xDirExtend < 0) {
			xDirExtend = 0;
		}
		if (radius < xDirExtend) {
			radius = xDirExtend;
		}
		double cosDeflection = MathUtil.cos(deflection);
		double tanDeflection = MathUtil.tan(deflection);
		double curYaw = location.getYaw() + yawValueAdd + startAngle * cosDeflection;
		double curPitch = location.getPitch() + pitchValueAdd + startAngle * cosDeflection * tanDeflection;
		double initX = location.getX();
		double initY = location.getY();
		double initZ = location.getZ();
		double motionYaw = rotSpeed * cosDeflection;
		double motionPitch = tanDeflection * motionYaw;
		int cycleIndex = (int) (rotAngle / rotSpeed);
		World world = location.getWorld();
		for (int i = 0; i <= cycleIndex; i++) {
			double z = initZ + radius * MathUtil.cos(curPitch) * MathUtil.cos(curYaw);
			double y = initY - radius * MathUtil.sin(curPitch);
			double x = initX - radius * MathUtil.cos(curPitch) * MathUtil.sin(curYaw);
			for (Player p : Bukkit.getOnlinePlayers()) {
				p.sendMessage(curYaw + "," + curPitch);
			}
			world.spawnParticle(Particle.REDSTONE, new Location(location.getWorld(), x, y, z),
					1, new Particle.DustOptions(Color.fromRGB(0, 255, 0), 0.4F));
			curYaw -= motionYaw;
			curPitch -= motionPitch;
		}
 */