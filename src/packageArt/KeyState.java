package packageArt;

public class KeyState {
	public int key;
	public int scanCode;
	public int action;
	public int scanMods;
	public KeyState(int pKey,int pScanCode,int pAction,int pScanMods)
	{
		key=pKey;
		scanCode=pScanCode;
		action=pAction;
		scanMods=pScanMods;
	}
}
