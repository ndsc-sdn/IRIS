package org.openflow.protocol.interfaces;

import java.nio.ByteBuffer;



public interface OFGetConfigReply extends OFMessage {

	public OFGetConfigReply setFlags(short value);
	public short getFlags();
	public boolean isFlagsSupported();
	public OFGetConfigReply setMissSendLength(short value);
	public short getMissSendLength();
	public boolean isMissSendLengthSupported();
	public OFGetConfigReply setMissSendLen(short value);
	public short getMissSendLen();
	public boolean isMissSendLenSupported();
	
	public OFGetConfigReply dup();

    public void readFrom(ByteBuffer data);

    public void writeTo(ByteBuffer data);

    public short computeLength();

    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req);
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff();
}
