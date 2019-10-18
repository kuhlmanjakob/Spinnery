package glib.container.common;

import glib.container.common.widget.Dropdown;
import glib.container.common.widget.DynamicImage;
import glib.container.common.widget.ItemSlot;
import glib.container.common.widget.Panel;
import glib.container.common.widget.Slider;
import glib.container.common.widget.StaticImage;
import glib.container.common.widget.Toggle;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;


// maybe an addWidgets which takes a vararg widgets?


public class TestContainer extends BaseContainer {
	public TestContainer(int synchronizationID, Inventory linkedInventory, PlayerInventory linkedPlayerInventory) {
		super(synchronizationID, linkedInventory, linkedPlayerInventory);
		linkedInventory = new BasicInventory(9);

		setLinkedPanel(new Panel(0, 0, -10, 150 + 32, 178 + 32, this));

		getLinkedPanel().setSizeX(172);
		getLinkedPanel().setSizeY(250);

		getLinkedPanel().getLinkedContainer().tick();

		getLinkedPanel().alignWithContainerEdge();

		StaticImage exampleStaticImage = new StaticImage(0, 20, 137, 59.2, 73, new Identifier("glib:textures/widget/catgirl.png"), linkedPanel);

		Slider exampleSlider = new Slider(0, 110, -5, 100, 12, 16, new Identifier("glib:textures/widget/test.png"), linkedPanel);

		Dropdown exampleDropdown1 = new Dropdown(331, 143, -3, 96, 18, "OwO who dis?", linkedPanel);
		Dropdown exampleDropdown2 = new Dropdown(331, 22, -3, 96, 18, "Whoms't ze fuck?", linkedPanel);

		ItemSlot exampleSlot1 = new ItemSlot(58, 140, -6, 18, 18, 0, linkedInventory, linkedPanel);
		ItemSlot exampleSlot2 = new ItemSlot(76, 140, -6, 18, 18, 1, linkedInventory, linkedPanel);
		ItemSlot exampleSlot3 = new ItemSlot(94, 140, -6, 18, 18, 2, linkedInventory, linkedPanel);

		DynamicImage exampleDynamicImage = new DynamicImage(0, 161, 170, 10, 10, linkedPanel,

		new Identifier("glib:textures/widget/0.png"),
		new Identifier("glib:textures/widget/1.png"),
		new Identifier("glib:textures/widget/2.png"),
		new Identifier("glib:textures/widget/3.png"),
		new Identifier("glib:textures/widget/4.png"),
		new Identifier("glib:textures/widget/5.png"),
		new Identifier("glib:textures/widget/6.png"),
		new Identifier("glib:textures/widget/7.png"));

		exampleDropdown1.setMovable(true);
		exampleDropdown2.setMovable(true);

		getLinkedPanel().addWidget(exampleStaticImage);
		getLinkedPanel().addWidget(exampleSlider);
		getLinkedPanel().addWidget(exampleDropdown1);
		getLinkedPanel().addWidget(exampleDropdown2);

		getLinkedPanel().addWidget(exampleSlot1);
		getLinkedPanel().addWidget(exampleSlot2);
		getLinkedPanel().addWidget(exampleSlot3);

		getLinkedPanel().addWidget(exampleDynamicImage);

		exampleSlot2.getSlot().setStack(new ItemStack(Items.BRAIN_CORAL, 64));

		for (int i = 0; i < 3; ++i) {
			exampleDropdown1.addWidget(new Toggle(0, 0, -4, 18, 18, linkedPanel));
		}

		exampleDropdown2.addWidget(new StaticImage(29.1, 40, 137, 72.6, 102.4, new Identifier("glib:textures/widget/cattegirl.png"), linkedPanel));

		exampleStaticImage.alignWithContainerCenter();
		exampleSlider.alignWithContainerCenter();
		exampleDynamicImage.alignWithContainerCenter();

		ItemSlot.addPlayerInventory(0, 18, 18, linkedPlayerInventory, linkedPanel);
	}
}
