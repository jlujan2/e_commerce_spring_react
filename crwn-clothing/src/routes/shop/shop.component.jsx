import{Routes, Route} from 'react-router-dom';
import { useEffect } from 'react';
import CategoriesPreview from '../categories-preview/categories-preview.component';
//import { getCategoriesAndDocuments } from '../../utils/firebase/firebase.utils';
import Category from '../category/category.component';
import { useDispatch } from 'react-redux';
import {fetchCategoriesStart} from '../../store/category/categories.action'
import './shop.styles.scss';

const Shop = () => {
    const dispatch =  useDispatch();

    useEffect(() => {
        //NOTE: ANY ASYC FUNCTION YOU HAVE WRAPPED IN ASYNC FUNCTION

        const getCategoriesMap = async () => {
            //const categoriesArray = await getCategoriesAndDocuments('categories');
            dispatch(fetchCategoriesStart());
        }

        getCategoriesMap();
    }, []);

    return (
        <Routes>
            <Route index element={<CategoriesPreview/>}></Route>
            <Route path=":category" element={<Category/>}></Route>
        </Routes>
       
    );
};

export default Shop;