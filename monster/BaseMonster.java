package monster;

public class BaseMonster {
    
    private int hp;
	private int mp;

    public final String name;
	public final int attack; 
	public final int defense;  
	public final int exp; 
	public final int money; 
	public final int max_hp; 
	public final int max_mp;

    public BaseMonster(String n, int a, int d, int e, int m, int mh, int mm) {
        name = n;
        attack = a;
        defense = d;
        exp = e;
        money = m;
        max_hp = mh;
        max_mp = mm;
    }

    public void setHP(int h) {
        if (h <= 0) { hp = 0; }
        else if (h >= max_hp) { hp = max_hp; }
        else { hp = h; }
    }
    
    public final int getHP(){
        return hp;
    }
    
    public void setMP(int m) {
        if (m <= 0) { mp = 0; }
        else if (m >= max_mp) { mp = max_mp; }
        else { mp = m; }
    }
    
    public final int getMP(){
        return mp;
    }
}
