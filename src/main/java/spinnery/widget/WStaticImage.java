package spinnery.widget;

import net.minecraft.util.Identifier;
import spinnery.client.BaseRenderer;

public class WStaticImage extends WWidget {
	protected Identifier texture;

	public WStaticImage(WAnchor anchor, double positionX, double positionY, double positionZ, double sizeX, double sizeY, Identifier texture, WPanel linkedPanel) {
		setLinkedPanel(linkedPanel);

		setAnchor(anchor);

		setAnchoredPositionX(positionX);
		setAnchoredPositionY(positionY);
		setPositionZ(positionZ);

		setSizeX(sizeX);
		setSizeY(sizeY);

		setTexture(texture);
	}

	public Identifier getTexture() {
		return texture;
	}

	public void setTexture(Identifier texture) {
		this.texture = texture;
	}

	@Override
	public void draw() {
		double x = getPositionX();
		double y = getPositionY();
		double z = getPositionZ();

		double sX = getSizeX();
		double sY = getSizeY();

		BaseRenderer.drawImage(x, y, z, sX, sY, getTexture());
	}
}
