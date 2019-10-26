package costum_particle_control.Gui.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import costum_particle_control.Gui.container.ContainerCostumizer;
import costum_particle_control.capability.particleItem.ParticleItemProvider;
import costum_particle_control.handlers.NetworkHandler;
import costum_particle_control.interfaces.IParticleItem;
import costum_particle_control.objects.message.MessageButtom;
import costum_particle_control.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class GuiCostumizer extends GuiContainer
{
	private static final String TEXTURE_PATH = Reference.MODID + ":" + "textures/gui/costumizer.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    private static final int BUTTON_PREFORM = 0;
    public static boolean open = true;
    private static final int TEXTFIELD_TYPE = 0;
    private static final int TEXTFIELD_AMOUNT = 1;
    private static final int TEXTFIELD_RANGE = 2;
    private static final int TEXTFIELD_MODEL = 3;
    private static final int TEXTFIELD_SPECIAL_1 = 4;
    private static final int TEXTFIELD_SPECIAL_2 = 5;

	private InventoryPlayer player;


    public static String particleType = "0";
    public static String particleAmount = "0";
    public static String particleRange = "0";
    public static String particleModel = "0";
    public static String particleSpecial_1 = "0";
    public static String particleSpecial_2 = "0";


	private GuiTextField textfield_type;
	private GuiTextField textfield_amount;
	private GuiTextField textfield_range;
	private GuiTextField textfield_model;
	private GuiTextField textfield_special_1;
	private GuiTextField textfield_special_2;
	
	private GuiTextField[] textfield;
	


	public GuiCostumizer(InventoryPlayer player,BlockPos pos, World world) 
	{
		super(new ContainerCostumizer(player,pos,world));
		this.xSize = 175;
        this.ySize = 183;
		this.player = player;

		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        //text
        textfield_type = new GuiTextField(TEXTFIELD_TYPE, this.fontRenderer, offsetX+48, offsetY+10, 20, 10);
        textfield_amount = new GuiTextField(TEXTFIELD_AMOUNT, this.fontRenderer, offsetX+48, offsetY+10+10+9, 20, 10);
        textfield_range = new GuiTextField(TEXTFIELD_RANGE, this.fontRenderer, offsetX+48+30, offsetY+10, 20, 10);
        textfield_model = new GuiTextField(TEXTFIELD_MODEL, this.fontRenderer, offsetX+48+30, offsetY+10+10+9, 20, 10);
        textfield_special_1 = new GuiTextField(TEXTFIELD_SPECIAL_1, this.fontRenderer, offsetX+48+60, offsetY+10, 20, 10);
        textfield_special_2 = new GuiTextField(TEXTFIELD_SPECIAL_2, this.fontRenderer, offsetX+48+60, offsetY+10+10+9, 20, 10);

        textfield = new GuiTextField[] {textfield_type, textfield_amount,textfield_range,textfield_model,textfield_special_1,textfield_special_2};


	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        for (GuiTextField field : textfield)
        {
            if (field!=null)        field.drawTextBox();
        }
//        if (textfield_type!=null)        textfield_type.drawTextBox();
//        if (textfield_amount!=null)        textfield_amount.drawTextBox();


    }
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
		GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.drawVerticalLine(88, 34+8-4, 100-8+4, 0xFF000000);
        this.drawHorizontalLine(7, 171, 34+8, 0xFF000000);
        this.drawHorizontalLine(7, 171, 100-8, 0xFF000000);
        
        String title = I18n.format("container.costumparticle.control");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
        
        this.fontRenderer.drawString(I18n.format("text.particle.type"), 12, 50, 0x404040);
        this.fontRenderer.drawString(I18n.format("text.particle.amount"), 12, 50+14, 0x404040);       
        this.fontRenderer.drawString(I18n.format("text.particle.range"), 12, 50+28, 0x404040);
        
        ItemStack stack = ContainerCostumizer.stackToEnchant;
        if (stack!=null && stack!=ItemStack.EMPTY)
        {
    		IParticleItem particle = stack.getCapability(ParticleItemProvider.PARTICLE_CAP, null);
    		if (particle!= null)
    		{
    			try
    			{
        			EnumParticleTypes par =  EnumParticleTypes.getParticleFromId(Integer.parseInt(textfield_type.getText()));
    				fontRenderer.drawString(par.getParticleName(), 62, 20, 0x404040);
    			}
    			catch(NumberFormatException ex) {}
    		}
        	if (open && particle!= null)
        	{
    			if (particle.getParticleType()!=0)
    			{
    				textfield_type.setText(String.valueOf(particle.getParticleType()));   				
    			}  			
    			if (particle.getParticleAmount()!=0)
    			{
    				textfield_amount.setText(String.valueOf(particle.getParticleAmount()));
    			}
    			if (particle.getParticleRange()!=0)
    			{
    				textfield_range.setText(String.valueOf(particle.getParticleRange()));
    			}
    			if (particle.getParticleModel()!=0)
    			{
    				textfield_model.setText(String.valueOf(particle.getParticleModel()));
    			}
    			if (particle.getParticleSpecial_1()!=0)
    			{
    				textfield_special_1.setText(String.valueOf(particle.getParticleSpecial_1()));
    			}
    			if (particle.getParticleSpecial_2()!=0)
    			{
    				textfield_special_2.setText(String.valueOf(particle.getParticleSpecial_2()));
    			}
    				
    			open = false;
    		}
        	
			
        }
        switch(textfield_model.getText())
        {
        case "1":
            this.fontRenderer.drawString(I18n.format("text.particle.model.1"), 12+80, 50, 0x404040);  
        	this.fontRenderer.drawString(I18n.format("text.particle.special_1.1"), 12+80, 50+14, 0x404040);
            this.fontRenderer.drawString(I18n.format("text.particle.special_2.1"), 12+80, 50+28, 0x404040);
            break;
        case "2":
        	this.fontRenderer.drawString(I18n.format("text.particle.model.2"), 12+80, 50, 0x404040);  
        	this.fontRenderer.drawString(I18n.format("text.particle.special_1.2"), 12+80, 50+14, 0x404040);
            this.fontRenderer.drawString(I18n.format("text.particle.special_2.2"), 12+80, 50+28, 0x404040);

            break;
        case "3":
        	this.fontRenderer.drawString(I18n.format("text.particle.model.3"), 12+80, 50, 0x404040);  
        	this.fontRenderer.drawString(I18n.format("text.particle.special_1.3"), 12+80, 50+14, 0x404040);
            this.fontRenderer.drawString(I18n.format("text.particle.special_2.3"), 12+80, 50+28, 0x404040);

            break;
        case "4":
        	this.fontRenderer.drawString(I18n.format("text.particle.model.4"), 12+80, 50, 0x404040);  
        	this.fontRenderer.drawString(I18n.format("text.particle.special_1.4"), 12+80, 50+14, 0x404040);
            this.fontRenderer.drawString(I18n.format("text.particle.special_2.4"), 12+80, 50+28, 0x404040);

            break;
        default:
        	this.fontRenderer.drawString(I18n.format("text.particle.model.default"), 12+80, 50, 0x404040);  
        	this.fontRenderer.drawString(I18n.format("text.particle.special_1.default"), 12+80, 50+14, 0x404040);
            this.fontRenderer.drawString(I18n.format("text.particle.special_2.default"), 12+80, 50+28, 0x404040);


        }
        


        //this.itemRender.renderItemAndEffectIntoGUI(item, 8, 20);
    }
    @SideOnly(Side.CLIENT)
    protected void actionPerformed(GuiButton button) throws IOException
    { 
        switch (button.id)
        {
        case BUTTON_PREFORM:

        	this.particleType = textfield_type.getText();
        	this.particleAmount = textfield_amount.getText();
        	this.particleRange = textfield_range.getText();
        	this.particleModel = textfield_model.getText();
        	this.particleSpecial_1 = textfield_special_1.getText();
        	this.particleSpecial_2 = textfield_special_2.getText();

        	NetworkHandler.sendToServer(new MessageButtom());
        	
        	
            break;
            
        default:
            super.actionPerformed(button);
            return;
        }
    }
    @Override
    public void initGui()
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        super.initGui();
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        //text
        textfield_type = new GuiTextField(TEXTFIELD_TYPE, this.fontRenderer, offsetX+12+50, offsetY+50, 20, 10) ;
        textfield_amount = new GuiTextField(TEXTFIELD_AMOUNT, this.fontRenderer, offsetX+12+50, offsetY+50+14, 20, 10);
        textfield_range = new GuiTextField(TEXTFIELD_RANGE, this.fontRenderer, offsetX+12+50, offsetY+50+28, 20, 10);
        
        textfield_model = new GuiTextField(TEXTFIELD_MODEL, this.fontRenderer, offsetX+12+130, offsetY+50, 20, 10);
        textfield_special_1 = new GuiTextField(TEXTFIELD_SPECIAL_1, this.fontRenderer, offsetX+12+130, offsetY+50+14, 20, 10);
        textfield_special_2 = new GuiTextField(TEXTFIELD_SPECIAL_2, this.fontRenderer, offsetX+12+130, offsetY+50+28, 20, 10);

        textfield = new GuiTextField[] {textfield_type, textfield_amount,textfield_range,textfield_model,textfield_special_1,textfield_special_2};

        for (GuiTextField field : textfield)
        {
            if (field!=null)        
            {
            	field.setEnableBackgroundDrawing(false);
            }
        }
        Keyboard.enableRepeatEvents(true);
        
        //button
        this.buttonList.add(new GuiButton(BUTTON_PREFORM, offsetX + 38, offsetY + 20, 15, 10, "")
        {
        			
            @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
            {
                if (this.visible)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    int x = mouseX - this.x, y = mouseY - this.y;
                    if (x >= 0 && y >= 0 && x < this.width && y < this.height)
                    {
                        this.drawTexturedModalRect(this.x, this.y, 20, 196, this.width, this.height);
                    }
                    else
                    {
                        this.drawTexturedModalRect(this.x, this.y, 20, 184, this.width, this.height);
                    }
                    
                }
            }
        });

        
        
    }
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException 
    {
        super.keyTyped(typedChar, keyCode);
        for (GuiTextField field : textfield)
        {
            if (!field.equals(null))	field.textboxKeyTyped(typedChar, keyCode);
        }
//        if (!textfield_type.equals(null))	textfield_type.textboxKeyTyped(typedChar, keyCode);
//        if (!textfield_amount.equals(null))	textfield_amount.textboxKeyTyped(typedChar, keyCode);

        

    }
    @Override
    public void updateScreen() 
    {
        super.updateScreen();
        for (GuiTextField field : textfield)
        {
        	if (!field.equals(null)) field.updateCursorCounter();
        }
//        if (!textfield_type.equals(null))textfield_type.updateCursorCounter();
//        if (!textfield_amount.equals(null))textfield_amount.updateCursorCounter();

    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException 
    {
    	for (GuiTextField field : textfield)
        {
            if (!field.equals(null)) field.mouseClicked(mouseX, mouseY, mouseButton);
        }
//        if (!textfield_type.equals(null))textfield_type.mouseClicked(mouseX, mouseY, mouseButton);
//        if (!textfield_amount.equals(null))textfield_amount.mouseClicked(mouseX, mouseY, mouseButton);

    	super.mouseClicked(mouseX, mouseY, mouseButton);

    }
}
