package Behavioural.Mediator

import Behavioural.Iterator.Channel
import Behavioural.Iterator.ChannelCollection
import Behavioural.Iterator.ChannelIterator
import Behavioural.Iterator.ChannelTypeEnum
import jdk.internal.org.objectweb.asm.TypeReference

class ChannelCollectionImpl : ChannelCollection {

    private val channelList = ArrayList<Channel>()

    override fun addChannel(channel: Channel) {
        channelList.add(channel)
    }

    override fun removeChannel(channel: Channel) {
        channelList.remove(channel)
    }

    override fun iterators(typeEnum: ChannelTypeEnum): ChannelIterator {
        return ChannelIteratorImpl(typeEnum, channelList)
    }


    private class ChannelIteratorImpl(
            private val typeReference: ChannelTypeEnum,
            private val channels: ArrayList<Channel>
    ) : ChannelIterator {

        private var position = 0

        override fun hasNext(): Boolean {
            while (position < channels.size){
                var chan = channels[position]

                if (chan.TYPE == typeReference || typeReference == ChannelTypeEnum.ALL){
                    return true
                }else{
                    position++
                }
            }

            return false
        }

        override fun nextt(): Channel {
            var channel = channels[position]
            position++
            return channel
        }
    }
}