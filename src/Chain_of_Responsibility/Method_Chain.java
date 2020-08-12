package Chain_of_Responsibility;



class Creature
{
	public String  name;
	public int attack,defense;
	public Creature(String name, int attack, int defense)
	{
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}
	
	  @Override
	  public String toString() // avoid printing Game
	  {
	    return "Creature{" +
	      "name='" + name + '\'' +
	      ", attack=" + attack + // !!!
	      ", defense=" + defense +
	      '}';
	  }
}

class CreatureModifier
{
	protected Creature creature;
	protected CreatureModifier next;
	
	public CreatureModifier(Creature creature)
	{
		this.creature = creature;
	}
	
	public void add(CreatureModifier cm)
	{
		if (next != null)
		{
			next.add(cm);
		}
		else
		{
			this.next = cm;
		}
	}
	
	public void handle()
	{
		if (next!= null) {
			next.handle();
		}
	}
}

class DoubleAttackModifier extends CreatureModifier
{
	public DoubleAttackModifier(Creature creature)
	{
		super(creature);
	}
	
	@Override
	public void handle()
	{
		creature.attack *= 2;
		System.out.println("Doubling " + creature.name + "'s attack.");
		super.handle();
	}
}

class IncreaseDefenseModifier extends CreatureModifier
{
	public IncreaseDefenseModifier(Creature creature)
	{
		super(creature);
	}
	
	@Override
	public void handle()
	{
		creature.defense += 1;
		System.out.println("Increasing " + creature.name + "'s defense by 1.");
		super.handle();
	}
}



class noBonusModifier extends CreatureModifier
{
	public noBonusModifier(Creature creature)
	{
		super(creature);
	}
	
	@Override
	public void handle()
	{
		System.out.println("No bonus for you");

	}
}

class DemoMethodChain
{
	public static void main(String[] args)
	{
		Creature goblin = new Creature("Goblin" , 1, 1);
		System.out.println(goblin);
		
		CreatureModifier root = new CreatureModifier(goblin);
		
		root.add(new noBonusModifier(goblin));
		
		root.add(new DoubleAttackModifier(goblin));
		
		root.add(new IncreaseDefenseModifier(goblin));
		root.handle();
		System.out.println(goblin);

		
		
	}
	
	
}