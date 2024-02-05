import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { Fragment, useEffect, useState } from "react";
import { selectCategoriesMap } from "../../store/category/categories.selector";
import ProductCard from "../../components/product-card/product-card.component";

const Category =() => {
    const {category} = useParams();
    const categoriesMap = useSelector(selectCategoriesMap);
    const [products, setProducts] = useState(categoriesMap[category]);

    useEffect(() => {
        setProducts(categoriesMap[category]);
    }, [category, categoriesMap])

    return (
      <Fragment>
        <h2 className="category-title">{category.toUpperCase()}</h2>
        <div className="category-container">
            {products &&
            products.map((product) => (
                <ProductCard key={product.id} product={product}/>
            ))}
        </div>
      </Fragment>
    )
}

export default Category;