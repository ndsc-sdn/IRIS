package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFStatisticsMeterConfigRequest extends OFStatisticsRequest implements org.openflow.protocol.interfaces.OFStatisticsMeterConfigRequest {
    public static int MINIMUM_LENGTH = 24;
    public static int CORE_LENGTH = 8;

    int  meter_id;
	int pad_1th;

    public OFStatisticsMeterConfigRequest() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)18));
		setStatisticsType(OFStatisticsType.valueOf((short)10, this.type));
    }
    
    public OFStatisticsMeterConfigRequest(OFStatisticsMeterConfigRequest other) {
    	super(other);
		this.meter_id = other.meter_id;
    }

	public int getMeterId() {
		return this.meter_id;
	}
	
	public OFStatisticsMeterConfigRequest setMeterId(int meter_id) {
		this.meter_id = meter_id;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isMeterIdSupported() {
		return true;
	}
			
	
	
	
	public OFStatisticsMeterConfigRequest dup() {
		return new OFStatisticsMeterConfigRequest(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.meter_id = data.getInt();
		this.pad_1th = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.meter_id);
		data.putInt(this.pad_1th);
    }

    public String toString() {
        return super.toString() +  ":OFStatisticsMeterConfigRequest-"+":meter_id=" + U32.f(meter_id);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
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
        		
		final int prime = 1559;
		int result = super.hashCode() * prime;
		result = prime * result + (int) meter_id;
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
        if (!(obj instanceof OFStatisticsMeterConfigRequest)) {
            return false;
        }
        OFStatisticsMeterConfigRequest other = (OFStatisticsMeterConfigRequest) obj;
		if ( meter_id != other.meter_id ) return false;
        return true;
    }
}
