package player;

public abstract class NovicePlayer{


    protected int level;
	protected int attack;
	protected int defense;
	protected int max_hp;
	protected int max_mp;
	protected int lvup_exp;
	protected int lastlvup_exp;

    
	private String name;
	private int hp;
	private int mp;
	private int exp;
	private int money;
    private int backpack_weight;

    /*
	private Item* backpack[6] = {NULL}; 
	private WeaponItem* weapon;
	private ArmorItem* armor;
    */
	
    public final int backpack_weight_limit;
	public final int backpack_slot_limit;
    
    public NovicePlayer(){
        backpack_weight_limit = 100;
        backpack_slot_limit = 6;
        backpack_weight = 0;
    }

    public NovicePlayer(int l, String n){
        backpack_weight_limit = 100;
        backpack_slot_limit = 6;
        setLevel(l);
	    setName(n);
        setHP(getMaxHP());
        setMP(getMaxMP());
        setExp(lastlvup_exp);
        setMoney(0);
        backpack_weight = 0;  
    }

    /*
    copy constructor but I remeber that java can copy directly using "="
    public NovicePlayer( NovicePlayer n){
        backpack_weight_limit = 100;
        backpack_slot_limit = 6;
        setLevel(n.getLevel());
	    setName(n.getName());
	    setHP(n.getHP());
	    setMP(n.getMP());
	    setExp(n.getExp());
	    setMoney(n.getMoney());
    }
    */

    public final String getName(){
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public final int getHP(){
        return hp;
    }
    
    public void setHP(int h) {
        if (h <= 0) { hp = 0; }
        else if (h >= getMaxHP()) { hp = getMaxHP(); }
        else { hp = h; }
    }

    public final int getMP(){
        return mp;
    }
    
    public void setMP(int m) {
        if (m <= 0) { mp = 0; }
        else if (m > getMaxHP()) { mp = getMaxMP(); }
        else { mp = m; }
    }

    public final int getExp(){
        return exp;
    }
    
    public final int getMoney(){
        return money;
    }

    public void setMoney(int m) {
        money = (0 <= m) ? m : 0;
    }
    
    public void setExp(int e) {
        if (e <= lastlvup_exp) {
            exp = lastlvup_exp;
        }
        else { exp = e; }
    }

    public final int getLevel(){
        return level;
    }

    public void setLevel(int l) {
        level = (1 <= l) ? l : 1;
        attack = 20 + 5 * getLevel();
        defense = 20 + 5 * getLevel();
        max_hp = 100 + 10 * getLevel();
        max_mp = 40 + 5 * getLevel();
        lvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        lastlvup_exp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }

    public final int getAttack(){
        return attack;
    }
    
    public final int getDefense(){
        return defense;
    }
    
    public final int getMaxHP(){
        return max_hp;
    }
    
    public final int getMaxMP(){
        return max_mp;
    }

    public final int getLvupExp(){
        return lvup_exp;
    }
    
    public abstract void specialSkill();

    /*
    public final WeaponItem getweapon(){
        return weapon;
    }

    public final ArmorItem getarmor(){
	    return armor;
    }

    public bool equipWeapon(WeaponItem w) {
	    if (w.level_required  >=  getLevel()) {
		    weapon = w;
		    return 1;
	    }
	    else { return 0; }
    }

    public bool equipArmor(ArmorItem a) {
	    if (a.level_required >= getLevel()) {
		    armor = a;
		    return 1;
	    }
	    else { return 0; }
    }

    publci void useConsumable(ConsumableItem c) {
	    c.use(this);
    }

    public bool putItem(Item it) {
	    for (int i = 0; i < backpack_slot_limit; i++) {
		
		    if (backpack[i] == NULL) {
			    if ((it.weight) <= (backpack_weight_limit - backpack_weight)) {
				    backpack[i] = it;
				    backpack_weight += it.weight;
				    return 1;
			    }
			    else { return 0; }
		    }

		    else { return 0; }
	    }
    }

    public tem takeItem(int n) {
	    Item i = NULL;

	    if (backpack[n] != NULL) {
		    i = backpack[n];
		    backpack[n] = NULL;
		    backpack_weight -= i.weight;
	    }
	return i;
    }   

    */
}


/*save and load in c++
string NovicePlayer::serialize() {
	string s = getName();
	for (int i = 0; i < 5; i++) {
		s += "$";
		switch (i)
		{
		case 0:
			s += to_string(getLevel());
			break;
		case 1:
			s += to_string(getHP());
			break;
		case 2:
			s += to_string(getMP());
			break;
		case 3:
			s += to_string(getExp());
			break;
		case 4:
			s += to_string(getMoney());
			break;
		default:
			break;
		}
	}
	return s;
}

NovicePlayer* NovicePlayer::unserialize(string s) {
	
	static NovicePlayer n;
	for (int i = 0; i < 6; i++) {

		int a = s.find("$");
		string si = s.substr(0, a);
	
		switch (i)
		{
		case 0:
			n.setName(si);
			break;
		case 1:
			n.setLevel(stoi(si));
			break;
		case 2:
			n.setHP(stoi(si));
			break;
		case 3:
			n.setMP(stoi(si));
			break;
		case 4:
			n.setExp(stoi(si));
			break;
		case 5:
			n.setMoney(stoi(si));
			break;
		default:
			break;
		};
		s.erase(0, (si.length() + 1));
	}

	return &n;
}
*/