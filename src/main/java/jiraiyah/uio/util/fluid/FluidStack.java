package jiraiyah.uio.util.fluid;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.fluid.Fluid;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

/**
 * Represents a stack of fluid in a game, encapsulating the fluid type and the amount.
 *
 * <p>This class is used to manage fluid quantities and their corresponding types
 * in a fluid handling system, such as in a Minecraft mod.</p>
 *
 * <p>It provides serialization and deserialization capabilities through codecs,
 * allowing for easy storage and network transmission of fluid data.</p>
 *
 * @param fluid The {@link FluidVariant} representing the type of fluid in the stack.
 * @param amount The long value representing the amount of fluid in the stack.
 */
public record FluidStack(FluidVariant fluid, long amount)
{
    /**
     * Codec for serializing and deserializing {@link FluidStack} instances.
     *
     * <p>This codec can be used for reading and writing fluid stack data to and from
     * various formats such as JSON or binary.</p>
     */
    public static final Codec<FluidStack> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            FluidVariant.CODEC.fieldOf("fluid").forGetter(FluidStack::fluid),
            Codec.LONG.fieldOf("amount").forGetter(FluidStack::amount)
    ).apply(inst, FluidStack::new));

    /**
     * Packet codec for sending and receiving {@link FluidStack} instances over the network.
     *
     * <p>This codec defines how to encode and decode fluid stack data when sending
     * it as a packet, ensuring that both the fluid type and amount are properly
     * transmitted.</p>
     */
    public static final PacketCodec<RegistryByteBuf, FluidStack> PACKET_CODEC = PacketCodec.tuple(
            FluidVariant.PACKET_CODEC, FluidStack::fluid,
            PacketCodecs.LONG, FluidStack::amount,
            FluidStack::new
    );
}