package littleMaidMobX.aimodes;

import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.registry.ModelManager;
import littleMaidMobX.textures.TextureBoxBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagList;

public class Mode_BookDecorder extends ModeBase {

	public Mode_BookDecorder(EntityLittleMaid pEntity) {
		super(pEntity);
	}

	@Override
	public int priority() {
		return 8000;
	}

	@Override
	public void addEntityMode(EntityAITasks pDefaultMove, EntityAITasks pDefaultTargeting) {
	}

	@Override
	public boolean interact(EntityPlayer pentityplayer, ItemStack pitemstack) {
		if (pitemstack.getItem() instanceof ItemWritableBook) {
			ItemWritableBook lwb = (ItemWritableBook)pitemstack.getItem();
			if (lwb.func_150930_a(pitemstack.getTagCompound())) {
				NBTTagList llist = pitemstack.getTagCompound().getTagList("pages", 8);
				String ls = "";
				for (int li = 0; li < llist.tagCount(); li++) {
//					NBTTagString ltex = (NBTTagString)llist.tagAt(li);
					ls += llist.getStringTagAt(li);
				}
				
				String lcommands[] = ls.split(";");
				String lcom[];
				TextureBoxBase lboxs[] = new TextureBoxBase[] {
						owner.textureData.textureBox[0],
						owner.textureData.textureBox[1]
				};
				int lcolor = owner.getColor();
				boolean lflag = false;
				for (String lt : lcommands) {
					lcom = lt.split(":");
					if (lcom.length > 1) {
						lcom[0] = lcom[0].trim();
						lcom[1] = lcom[1].trim();
						
						try {
							if (lcom[0].equals("color")) {
								lcolor = Integer.valueOf(lcom[1]) & 0x0f;
								lflag = true;
							}
							else if (lcom[0].equals("texture")) {
								TextureBoxBase lbox = ModelManager.instance.getTextureBox(lcom[1]);
								if (lbox != null) {
									lboxs[0] = lbox;
									lflag = true;
								}
							}
							else if (lcom[0].equals("armor")) {
								TextureBoxBase lbox = ModelManager.instance.getTextureBox(lcom[1]);
								if (lbox != null) {
									lboxs[1] = lbox;
									lflag = true;
								}
							}
							else if (lcom[0].equals("dominantArm")) {
								int li = Integer.valueOf(lcom[1]);
								owner.setDominantArm(li);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (pentityplayer.worldObj.isRemote) {
					if (lflag) {
						ModelManager.instance.postSetTexturePack(owner, lcolor, lboxs);
					}
				}
				return true;
			}
		}
		return false;
	}

}
