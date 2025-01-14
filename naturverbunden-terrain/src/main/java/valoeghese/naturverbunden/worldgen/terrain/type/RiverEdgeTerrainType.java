/*
 * Naturverbunden
 * Copyright (C) 2021 Valoeghese
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package valoeghese.naturverbunden.worldgen.terrain.type;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class RiverEdgeTerrainType extends TerrainType {
	public RiverEdgeTerrainType(TerrainType original, RegistryKey<Biome> biome, double river, double bias) {
		super(biome, original.getCategory());

		this.original = original;
		this.river = river;
		this.bias = bias;
	}

	private final TerrainType original;
	private final double river;
	private final double bias;

	@Override
	public double getHeight(int x, int z) {
		return this.river * this.bias + this.original.getHeight(x, z) * (1.0 - this.bias);
	}
}
