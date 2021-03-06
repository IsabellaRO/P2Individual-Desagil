package br.pro.hashi.ensino.desagil.lucianogic.model;

public class NotGate extends Gate {
	private NandGate nandGate;

	public NotGate() {
		super(1, 1);
		
		name = "NOT";
		nandGate = new NandGate();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate.connect(emitter, 0);
		nandGate.connect(emitter, 1);
	}

	@Override
	protected boolean doRead(int index) {
		return nandGate.read();
	}
}