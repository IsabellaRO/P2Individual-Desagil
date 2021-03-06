package br.pro.hashi.ensino.desagil.lucianogic.model;

public class NandGate extends Gate {
	private Emitter[] emitters;

	public NandGate() {
		super(2, 1);
		
		name = "NAND";
		emitters = new Emitter[2];
	}


	@Override
	protected void doConnect(Emitter emitter, int index) {
		emitters[index] = emitter;
	}

	@Override
	protected boolean doRead(int index) {
		return !(emitters[0].read() && emitters[1].read());
	}
}