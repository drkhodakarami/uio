package jiraiyah.uio.util.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;


public record CoordinateData(BlockPos pos, String dimension)
{
    public static final Codec<CoordinateData> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    BlockPos.CODEC.fieldOf("pos").forGetter(CoordinateData::pos),
                    Codec.STRING.fieldOf("dimension").forGetter(CoordinateData::dimension)
            ).apply(inst, CoordinateData::new));
}