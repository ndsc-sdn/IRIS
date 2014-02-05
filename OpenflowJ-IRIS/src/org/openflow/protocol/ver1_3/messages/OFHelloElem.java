package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFHelloElem   implements org.openflow.protocol.interfaces.OFHelloElem {
    public static int MINIMUM_LENGTH = 4;
    public static int CORE_LENGTH = 4;

    OFHelloElemType  type;
	short  length;

    public OFHelloElem() {
        
    }
    
    public OFHelloElem(OFHelloElem other) {
    	this.type = other.type;
		this.length = other.length;
    }

	public org.openflow.protocol.interfaces.OFHelloElemType getType() {
		return OFHelloElemType.to(this.type);
	}
	
	public OFHelloElem setType(org.openflow.protocol.interfaces.OFHelloElemType type) {
		this.type = OFHelloElemType.from(type);
		return this;
	}
	
	public OFHelloElem setType(OFHelloElemType type) {
		this.type = type;
		return this;
	}

	@org.codehaus.jackson.annotate.JsonIgnore	
	public boolean isTypeSupported() {
		return true;
	}
	
	public short getLength() {
		return this.length;
	}
	
	public OFHelloElem setLength(short length) {
		this.length = length;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isLengthSupported() {
		return true;
	}
			
	
	
	
	public OFHelloElem dup() {
		return new OFHelloElem(this);
	}
	
    public void readFrom(ByteBuffer data) {
        this.type = OFHelloElemType.valueOf(OFHelloElemType.readFrom(data));
		this.length = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putShort(this.type.getTypeValue());
		data.putShort(this.length);
    }

    public String toString() {
        return  ":OFHelloElem-"+":type=" + type.toString() + 
		":length=" + U16.f(length);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req) {
    	return (short)((total + (req-1))/req*req - total);
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	short total = computeLength();
    	return (short)(total - (short)MINIMUM_LENGTH + alignment(total, 0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2441;
		int result = super.hashCode() * prime;
		result = prime * result + ((type == null)?0:type.hashCode());
		result = prime * result + (int) length;
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFHelloElem)) {
            return false;
        }
        OFHelloElem other = (OFHelloElem) obj;
		if ( type == null && other.type != null ) { return false; }
		else if ( !type.equals(other.type) ) { return false; }
		if ( length != other.length ) return false;
        return true;
    }
}
