package br.pro.hashi.ensino.desagil.lucianogic.model;

public abstract class Gate implements Receiver, Emitter {
	private int sizeIn;
	private int sizeOut;
	protected String name;

	protected Gate(int sizeIn, int sizeOut) {
		this.sizeIn = sizeIn;
		this.sizeOut = sizeOut;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getIn() {
		return sizeIn;
	}
	
	public int getOut() {
		return sizeOut;
	}

	@Override
	public void connect(Emitter emitter, int index) {
		if(index < 0 || index >= sizeIn) {
			throw new IndexOutOfBoundsException();
		}
		doConnect(emitter, index);
	}
	
	@Override
	public boolean read() {
		return doRead(0);
	}

	public boolean read(int index) {
		if(index < 0 || index >= sizeOut) {
			throw new IndexOutOfBoundsException();
		}
		return doRead(index);
	}

	protected abstract boolean doRead(int index);

	protected abstract void doConnect(Emitter emitter, int index);
}