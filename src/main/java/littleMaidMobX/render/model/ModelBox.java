package littleMaidMobX.render.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;

public class ModelBox extends ModelBoxBase {

	/**
	 * @param pMRenderer
	 * @param pArg
	 * textureX, textureY, posX, posY, posZ, width, height, depth, sizeAdjust
	 */
	public ModelBox(ModelRenderer pMRenderer, int pTexX, int pTexY,
			float pX, float pY, float pZ,
			int pW, int pH, int pD, float pSize) {
		posX1 = pX;
		posY1 = pY;
		posZ1 = pZ;
		posX2 = pX + (float)pW;
		posY2 = pY + (float)pH;
		posZ2 = pZ + (float)pD;
		vertexPositions = new PositionTextureVertex[8];
		quadList = new TexturedQuad[6];
		float lx = pX + (float)pW;
		float ly = pY + (float)pH;
		float lz = pZ + (float)pD;
		pX -= pSize;
		pY -= pSize;
		pZ -= pSize;
		lx += pSize;
		ly += pSize;
		lz += pSize;
		
		if (pMRenderer.mirror) {
			float var14 = lx;
			lx = pX;
			pX = var14;
		}

		PositionTextureVertex lxyz = new PositionTextureVertex(pX, pY, pZ, 0.0F, 0.0F);
		PositionTextureVertex lwyz = new PositionTextureVertex(lx, pY, pZ, 0.0F, 8.0F);
		PositionTextureVertex lwhz = new PositionTextureVertex(lx, ly, pZ, 8.0F, 8.0F);
		PositionTextureVertex lxhz = new PositionTextureVertex(pX, ly, pZ, 8.0F, 0.0F);
		PositionTextureVertex lxyd = new PositionTextureVertex(pX, pY, lz, 0.0F, 0.0F);
		PositionTextureVertex lwyd = new PositionTextureVertex(lx, pY, lz, 0.0F, 8.0F);
		PositionTextureVertex lwhd = new PositionTextureVertex(lx, ly, lz, 8.0F, 8.0F);
		PositionTextureVertex lxhd = new PositionTextureVertex(pX, ly, lz, 8.0F, 0.0F);
		vertexPositions[0] = lxyz;
		vertexPositions[1] = lwyz;
		vertexPositions[2] = lwhz;
		vertexPositions[3] = lxhz;
		vertexPositions[4] = lxyd;
		vertexPositions[5] = lwyd;
		vertexPositions[6] = lwhd;
		vertexPositions[7] = lxhd;
		quadList[0] = new TexturedQuad(new PositionTextureVertex[] {lwyd, lwyz, lwhz, lwhd}, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pD, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[1] = new TexturedQuad(new PositionTextureVertex[] {lxyz, lxyd, lxhd, lxhz}, pTexX, pTexY + pD, pTexX + pD, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[2] = new TexturedQuad(new PositionTextureVertex[] {lwyd, lxyd, lxyz, lwyz}, pTexX + pD, pTexY, pTexX + pD + pW, pTexY + pD, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[3] = new TexturedQuad(new PositionTextureVertex[] {lwhz, lxhz, lxhd, lwhd}, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pW, pTexY, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[4] = new TexturedQuad(new PositionTextureVertex[] {lwyz, lxyz, lxhz, lwhz}, pTexX + pD, pTexY + pD, pTexX + pD + pW, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[5] = new TexturedQuad(new PositionTextureVertex[] {lxyd, lwyd, lwhd, lxhd}, pTexX + pD + pW + pD, pTexY + pD, pTexX + pD + pW + pD + pW, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		
		if (pMRenderer.mirror) {
			for (int li = 0; li < this.quadList.length; ++li) {
				this.quadList[li].flipFace();
			}
		}
	}

}
