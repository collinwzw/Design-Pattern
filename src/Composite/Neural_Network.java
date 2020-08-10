package Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

interface SomeNeurons extends Iterable<Neuron>
{
	default void connectTo(SomeNeurons other)
	{
		if (this == other)
		{
			return;
		}
		for (Neuron from: this) {
			for (Neuron to:other) {
				from.out.add(to);
				to.in.add(from);
			}
		}
	}
}


class Neuron implements SomeNeurons
{
	public ArrayList<Neuron> in, out;
//	public void connectTo(Neuron other)
//	{
//		out.add(other);
//		other.in.add(this);
//		
//	}

	@Override
	public Iterator<Neuron> iterator() {
		// TODO Auto-generated method stub
		return Collections.singleton(this).iterator();
	}
	
	@Override
	public void forEach(Consumer<? super Neuron> action)
	{
		action.accept(this);
	}
	
	@Override
	public Spliterator<Neuron> spliterator() {
		// TODO Auto-generated method stub
		return Collections.singleton(this).spliterator();
	}
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons
{
	
}


class DemoNN
{
	public static void main(String[] args)
	{
		Neuron n = new Neuron();
		Neuron n1 = new Neuron();
		NeuronLayer nl1 = new NeuronLayer();
		NeuronLayer nl2 = new NeuronLayer();
		
		n.connectTo(n1);
		n.connectTo(nl1);
		
		
	}
}