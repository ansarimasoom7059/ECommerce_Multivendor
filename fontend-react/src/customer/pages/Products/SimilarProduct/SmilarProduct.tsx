import React from 'react'
import ProductCard from '../ProductCard/ProductCard'
import { images } from '../Products'
import SimilarProductCard from './SimilarProductCard'
import { useAppSelector } from '../../../../Redux Toolkit/Store'
import { Product } from '../../../../types/productTypes'

const SmilarProduct = ({categoryId}:any) => {
  const { products } = useAppSelector((store) => store);
  return (
    <div>
        <div className='grid lg:grid-cols-6 md:grid-cols-4 sm:grid-cols-2 grid-cols-1 justify-between gap-4 gap-y-8'>

        {products.products.map((item,index) => <div 
            key = {item.id} className=''>
              <SimilarProductCard product={item} />
            </div>)}

        </div>
    </div>
  )
}

export default SmilarProduct