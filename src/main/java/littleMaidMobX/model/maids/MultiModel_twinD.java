package littleMaidMobX.model.maids;
	public ModelRenderer longhearR;
	public ModelRenderer longhearL;
	public ModelRenderer kamidomeR;
	public ModelRenderer kamidomeL;
		this(0.0F);
	}
		this(f, 0.0F);
	}
		this(f, f1, 64, 32);
	}
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		longhearR = new ModelRenderer(this, 52, 13);
		longhearR.addBox(2.5F, -8F, 7.4F, 2, 18, 1);
		longhearR.setRotationPoint(0F, 0F, 0F);
		longhearL.addBox(-4.5F, -8F, 7.4F, 2, 18, 1);
		longhearL.setRotationPoint(0F, 0F, 0F);
		kamidomeR.addBox(1F, -7F, 6.5F, 2, 2, 1);
		kamidomeR.setRotationPoint(0F, 0F, 0F);
		kamidomeL.addBox(-3F, -7F, 6.5F, 2, 2, 1);
		kamidomeL.setRotationPoint(0F, 0F, 0F);
				kamidomeL.rotateAngleX = 0.296706F;
		longhearR.rotateAngleY = kamidomeR.rotateAngleY = 0.296706F;
		longhearL.rotateAngleY = kamidomeL.rotateAngleY = -0.296706F;
		longhearR.rotateAngleZ = -0.1745329F;
		longhearL.rotateAngleZ = 0.1745329F;
		setCapsValue(null, caps_visible, Tail, false);
		setCapsValue(null, caps_visible, SideTailL, false);
		setCapsValue(null, caps_visible, SideTailR, false);
		setCapsValue(null, caps_visible, ChignonB, false);
		if (isAfterInit) afterInit(f, f1);
	}
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(longhearR);
		bipedHead.addChild(longhearL);
		bipedHead.addChild(kamidomeR);
		bipedHead.addChild(kamidomeL);
	}
}