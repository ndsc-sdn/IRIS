/**
*    Copyright 2011, Big Switch Networks, Inc. 
*    Originally created by David Erickson, Stanford University
* 
*    Licensed under the Apache License, Version 2.0 (the "License"); you may
*    not use this file except in compliance with the License. You may obtain
*    a copy of the License at
*
*         http://www.apache.org/licenses/LICENSE-2.0
*
*    Unless required by applicable law or agreed to in writing, software
*    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
*    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
*    License for the specific language governing permissions and limitations
*    under the License.
**/

package etri.sdn.controller.module.linkdiscovery;

import org.openflow.util.HexString;

/**
 * This class represents a Link.
 * Currently, a link is four-tuple of 
 * source switch identifier, source switch port, 
 * destination switch identifier, and destination switch port. 
 * 
 * This file is no different from Floodlight version.
 * 
 * @author bjlee
 *
 */
public class Link {

    private long src;
    private short srcPort;
    private long dst;
    private short dstPort;

    /**
     * Constructor 
     * 
     * @param srcId		source switch identifier
     * @param srcPort	source port 
     * @param dstId		destination switch identifier
     * @param dstPort	destination port
     */
    public Link(long srcId, short srcPort, long dstId, short dstPort) {
        this.src = srcId;
        this.srcPort = srcPort;
        this.dst = dstId;
        this.dstPort = dstPort;
    }

    /**
     * Convenience constructor.
     * The only difference from the {@link #Link(long, short, long, short)} 
     * is the type of second and fourth parameter (int)
     * 
     * @param srcId
     * @param srcPort
     * @param dstId
     * @param dstPort
     */
    public Link(long srcId, int srcPort, long dstId, int dstPort) {
        this.src = srcId;
        this.srcPort = (short) srcPort;
        this.dst = dstId;
        this.dstPort = (short) dstPort;
    }

    public long getSrc() {
        return src;
    }

    public short getSrcPort() {
        return srcPort;
    }

    public long getDst() {
        return dst;
    }

    public short getDstPort() {
        return dstPort;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (dst ^ (dst >>> 32));
        result = prime * result + dstPort;
        result = prime * result + (int) (src ^ (src >>> 32));
        result = prime * result + srcPort;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Link other = (Link) obj;
        if (dst != other.dst)
            return false;
        if (dstPort != other.dstPort)
            return false;
        if (src != other.src)
            return false;
        if (srcPort != other.srcPort)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Link [src=" + HexString.toHexString(this.src) 
                + " outPort="
                + (srcPort & 0xffff)
                + ", dst=" + HexString.toHexString(this.dst)
                + ", inPort="
                + (dstPort & 0xffff)
                + "]";
    }
    
    /**
     * This method is never used, thus soon will be removed from the source tree.
     * 
     * @return		String to-be-used as a key (for what?)
     * @deprecated
     */
    public String toKeyString() {
    	return (HexString.toHexString(this.src) + "|" +
    			(this.srcPort & 0xffff) + "|" +
    			HexString.toHexString(this.dst) + "|" +
    		    (this.dstPort & 0xffff) );
    }
}

