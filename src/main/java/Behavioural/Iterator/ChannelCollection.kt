package Behavioural.Iterator

interface ChannelCollection {

    fun addChannel(channel: Channel)
    fun removeChannel(channel: Channel)
    fun iterators(typeEnum: ChannelTypeEnum): ChannelIterator
}