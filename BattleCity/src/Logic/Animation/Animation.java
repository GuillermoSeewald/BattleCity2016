package Logic.Animation;

import java.awt.Image;

public abstract class Animation {
	protected Image images[];
	protected int posInAnimations;
	protected int actualImage;
	
	public abstract void buildImages();
	public void setPosInAnimations(int x){
		posInAnimations=x;
	}
	public int getPosInAnimations(){
		return posInAnimations;
	}
}