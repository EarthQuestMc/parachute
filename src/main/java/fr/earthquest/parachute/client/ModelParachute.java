package fr.earthquest.parachute.client;

import fr.earthquest.parachute.common.Parachute;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelParachute extends ModelBase {

	static final int w = 16;
	static final int d = 16;
	static final int h = 1;
	private final boolean smallCanopy;

	public ParachuteModelRenderer[] sections = new ParachuteModelRenderer[7];

	public ModelParachute()
	{
		smallCanopy = Parachute.instance.isSmallCanopy();

		// small canopy sections
		sections[0] = new ParachuteModelRenderer(0, 0);
		sections[0].addBox(-8F, 0F, -8F, w, h, d);

		sections[1] = new ParachuteModelRenderer(0, 0);
		sections[1].addBox(-8F, 0F, -16F, w, h, d);
		sections[1].setRotationPoint(0F, 0F, -8F);
		sections[1].rotateAngleX = 6.021385919380437F;

		sections[2] = new ParachuteModelRenderer(0, 0);
		sections[2].addBox(-8F, 0F, 0F, w, h, d);
		sections[2].setRotationPoint(0F, 0F, 8F);
		sections[2].rotateAngleX = 0.2617993877991494F;
		// large canopy sections
		sections[3] = new ParachuteModelRenderer(0, 0);
		sections[3].addBox(-8F, -1F, -16F, w, h, d);
		sections[3].rotateAngleX = 3.27249234748937F;

		sections[4] = new ParachuteModelRenderer(0, 0);
		sections[4].addBox(-8F, -1F, 0F, w, h, d);
		sections[4].rotateAngleX = 3.01069295969022F;

		sections[5] = new ParachuteModelRenderer(0, 0);
		sections[5].addBox(-8F, 0F, -24F, w, h, d);
		sections[5].setRotationPoint(0F, 0F, -8F);
		sections[5].rotateAngleX = 6.021385919380437F;

		sections[6] = new ParachuteModelRenderer(0, 0);
		sections[6].addBox(-8F, 0F, 8F, w, h, d);
		sections[6].setRotationPoint(0F, 0F, 8F);
		sections[6].rotateAngleX = 0.2617993877991494F;
	}

	public void renderSmallCanopy(float center)
	{
		for (int k = 0; k < 3; k++) {
			sections[k].render(center);
		}
	}

	public void renderLargeCanopy(float center)
	{
		for (int k = 3; k < 7; k++) {
			sections[k].render(center);
		}
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (smallCanopy) {
			renderSmallCanopy(f5);
		} else {
			renderLargeCanopy(f5);
		}
	}

}
