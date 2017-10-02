package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xorUp;
	private AndGate andDown;
	
	public HalfGate() {
		super(2, 2);
		
		name = "HALF";
		xorUp = new XorGate();
		andDown = new AndGate();
		
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		xorUp.connect(emitter, index);
		andDown.connect(emitter, index);

	}
	@Override
	protected boolean doRead(int index) {
		if(index == 1){
			return andDown.read();}
		else {
			return xorUp.read();}
		}

}