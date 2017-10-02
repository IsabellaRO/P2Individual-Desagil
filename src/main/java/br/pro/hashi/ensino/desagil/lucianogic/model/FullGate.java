package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate{
	private XorGate xorLeft;
	private XorGate xorRight;
	private AndGate andUp;
	private AndGate andDown;
	private OrGate finalOr;
	
	public FullGate() {
		super(3, 2);
		
		name = "FULL";
		xorLeft = new XorGate();
		xorRight = new XorGate();
		andUp = new AndGate();
		andDown = new AndGate();
		finalOr = new OrGate();
	
		xorRight.connect(xorLeft, 0);
		andUp.connect(xorLeft, 0);
		finalOr.connect(andUp, 0);
		finalOr.connect(andDown, 1);
	}
	

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index == 0){
			xorLeft.connect(emitter, 0);
			andDown.connect(emitter, 0);
		}
		else if(index == 1){
			xorLeft.connect(emitter, 1);
			andDown.connect(emitter, 1);
		}
		else{
			andUp.connect(emitter, 1);
			xorRight.connect(emitter, 1);
		}
	
	}
	
	@Override
	protected boolean doRead(int index) {
		if(index == 0){
			return xorRight.read();}
		else {
			return finalOr.read();}
		}
	
	}
