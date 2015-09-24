package com.iamtechi27.techicraftmod.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffFireball extends EntitySmallFireball{

	public EntityStaffFireball(World world, EntityLivingBase shooter) {
		super(world, shooter.posX, shooter.posY + shooter.getEyeHeight(), shooter.posZ, shooter.getLook(1).xCoord, shooter.getLook(1).yCoord, shooter.getLook(1).zCoord);
		this.shootingEntity = shooter;
	}
	
	public EntityStaffFireball(World world, EntityLivingBase shooter, double posX, double posY, double posZ, double accelX, double accelY, double accelZ) {
		super(world, posX, posY, posZ, accelX, accelY, accelZ);
		this.shootingEntity = shooter;
	}
	
	public void onImpact(MovingObjectPosition position)
    {
        if (!this.worldObj.isRemote) {
            if (position.entityHit != null)
            {
                if (!position.entityHit.isImmuneToFire() && position.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 10.0F))
                {
                    position.entityHit.setFire(5);
                }
            }
            this.setDead();
        }
    }
	
}
